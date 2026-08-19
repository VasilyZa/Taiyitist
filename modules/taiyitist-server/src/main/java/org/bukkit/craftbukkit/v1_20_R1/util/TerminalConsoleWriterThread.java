package org.bukkit.craftbukkit.v1_20_R1.util;

import com.mojang.logging.LogQueues;
import java.util.concurrent.locks.LockSupport;
import org.bukkit.ChatColor;
import org.jline.reader.LineReader;

/**
 * Bridges the existing Log4j queue into JLine 3. printAbove is the same mechanism used by Leaf's
 * terminal console appender: log messages appear above the active input buffer and the cursor is
 * restored by JLine itself.
 */
public class TerminalConsoleWriterThread extends Thread {
    private final LineReader reader;

    public TerminalConsoleWriterThread(java.io.OutputStream ignoredOutput, LineReader reader) {
        super("TerminalConsoleWriter");
        this.reader = reader;
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            String message = LogQueues.getNextLogEvent("TerminalConsole");
            if (message == null) {
                LockSupport.parkNanos(1_000_000L);
                continue;
            }

            try {
                reader.printAbove(render(message));
            } catch (Throwable ignored) {
                // The terminal may be closed while the server is shutting down.
            }
        }
    }

    private String render(String message) {
        boolean ansiSupported = reader.getTerminal().getType() != null
                && !TerminalTypes.isDumb(reader.getTerminal().getType());
        String translated = translateLegacyColors(message);
        if (!ansiSupported) {
            return stripAnsi(translated);
        }
        if (translated.indexOf('\u001B') >= 0) {
            return translated + "\u001B[0m";
        }

        String levelColor;
        if (message.contains(" ERROR]") || message.contains(" FATAL]")) {
            levelColor = "\u001B[31m";
        } else if (message.contains(" WARN]")) {
            levelColor = "\u001B[33m";
        } else if (message.contains(" DEBUG]") || message.contains(" TRACE]")) {
            levelColor = "\u001B[90m";
        } else {
            levelColor = "\u001B[37m";
        }
        return levelColor + translated + "\u001B[0m";
    }

    private static String translateLegacyColors(String message) {
        StringBuilder result = new StringBuilder(message.length() + 16);
        for (int i = 0; i < message.length(); i++) {
            char current = message.charAt(i);
            if (current != ChatColor.COLOR_CHAR || i + 1 >= message.length()) {
                result.append(current);
                continue;
            }

            char code = Character.toLowerCase(message.charAt(++i));
            switch (code) {
                case '0' -> result.append("\u001B[30m");
                case '1' -> result.append("\u001B[34m");
                case '2' -> result.append("\u001B[32m");
                case '3' -> result.append("\u001B[36m");
                case '4' -> result.append("\u001B[31m");
                case '5' -> result.append("\u001B[35m");
                case '6' -> result.append("\u001B[33m");
                case '7' -> result.append("\u001B[37m");
                case '8' -> result.append("\u001B[90m");
                case '9' -> result.append("\u001B[94m");
                case 'a' -> result.append("\u001B[92m");
                case 'b' -> result.append("\u001B[96m");
                case 'c' -> result.append("\u001B[91m");
                case 'd' -> result.append("\u001B[95m");
                case 'e' -> result.append("\u001B[93m");
                case 'f' -> result.append("\u001B[97m");
                case 'l' -> result.append("\u001B[1m");
                case 'm' -> result.append("\u001B[9m");
                case 'n' -> result.append("\u001B[4m");
                case 'o' -> result.append("\u001B[3m");
                case 'r' -> result.append("\u001B[0m");
                default -> result.append(ChatColor.COLOR_CHAR).append(code);
            }
        }
        return result.toString();
    }

    private static String stripAnsi(String message) {
        return message.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    private static final class TerminalTypes {
        private TerminalTypes() {
        }

        private static boolean isDumb(String type) {
            return "dumb".equalsIgnoreCase(type) || "unsupported".equalsIgnoreCase(type);
        }
    }
}
