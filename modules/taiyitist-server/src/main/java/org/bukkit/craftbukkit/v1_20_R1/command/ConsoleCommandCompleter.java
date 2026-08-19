package org.bukkit.craftbukkit.v1_20_R1.command;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.util.Waitable;
import org.bukkit.event.server.TabCompleteEvent;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;

public class ConsoleCommandCompleter implements Completer {

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        CraftServer server = Bukkit.getServer() instanceof CraftServer craftServer ? craftServer : null;
        if (server == null) {
            return;
        }

        final String buffer = line.line();
        Waitable<List<String>> waitable = new Waitable<List<String>>() {
            @Override
            protected List<String> evaluate() {
                List<String> offers = server.getCommandMap().tabComplete(server.getConsoleSender(), buffer);

                TabCompleteEvent tabEvent = new TabCompleteEvent(server.getConsoleSender(), buffer, (offers == null) ? Collections.emptyList() : offers);
                server.getPluginManager().callEvent(tabEvent);

                return tabEvent.isCancelled() ? Collections.emptyList() : tabEvent.getCompletions();
            }
        };
        server.getServer().bridge$processQueue().add(waitable);
        try {
            List<String> offers = waitable.get();
            if (offers != null) {
                for (String offer : offers) {
                    if (offer != null && !offer.isEmpty()) {
                        candidates.add(new Candidate(offer));
                    }
                }
            }
        } catch (ExecutionException e) {
            server.getLogger().log(Level.WARNING, "Unhandled exception when tab completing", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
