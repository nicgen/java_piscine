import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, String> matchesFirstToSecond = new HashMap<>();
        if (first == null || second == null || first.isEmpty() || second.isEmpty()) {
            return matchesFirstToSecond;
        }

        // Precompute ranking for the "second" side: for each member, rank of each preferred partner from "first"
        Map<String, Map<String, Integer>> secondRanks = new HashMap<>();
        for (Map.Entry<String, List<String>> e : second.entrySet()) {
            Map<String, Integer> rank = new HashMap<>();
            List<String> prefs = e.getValue();
            if (prefs != null) {
                for (int i = 0; i < prefs.size(); i++) {
                    rank.put(prefs.get(i), i);
                }
            }
            secondRanks.put(e.getKey(), rank);
        }

        // Track current engagement from the perspective of the "second" side
        Map<String, String> matchesSecondToFirst = new HashMap<>();

        // For each proposer from "first", track next preference index to propose to
        Map<String, Integer> nextProposalIndex = new HashMap<>();
        Queue<String> freeProposers = new ArrayDeque<>();
        for (String proposer : first.keySet()) {
            if (proposer != null) {
                freeProposers.add(proposer);
                nextProposalIndex.put(proposer, 0);
            }
        }

        // Gale-Shapley algorithm: "first" proposes to "second"
        while (!freeProposers.isEmpty()) {
            String proposer = freeProposers.poll();
            List<String> prefs = first.get(proposer);
            Integer idx = nextProposalIndex.get(proposer);
            if (prefs == null || idx == null || idx >= prefs.size()) {
                // No more preferences to propose; skip
                continue;
            }

            String candidate = prefs.get(idx);
            nextProposalIndex.put(proposer, idx + 1);

            // If candidate is null or not in "second", skip to next option
            if (candidate == null || !second.containsKey(candidate)) {
                freeProposers.add(proposer); // try next preference later
                continue;
            }

            String currentPartner = matchesSecondToFirst.get(candidate);
            if (currentPartner == null) {
                // Candidate is free, accept proposal
                matchesSecondToFirst.put(candidate, proposer);
                matchesFirstToSecond.put(proposer, candidate);
            } else {
                // Candidate compares current partner with new proposer
                Map<String, Integer> rank = secondRanks.get(candidate);
                int currentRank = rank.getOrDefault(currentPartner, Integer.MAX_VALUE);
                int newRank = rank.getOrDefault(proposer, Integer.MAX_VALUE);

                if (newRank < currentRank) {
                    // Candidate prefers new proposer
                    matchesSecondToFirst.put(candidate, proposer);
                    matchesFirstToSecond.put(proposer, candidate);
                    // The old partner becomes free again
                    matchesFirstToSecond.remove(currentPartner);
                    freeProposers.add(currentPartner);
                } else {
                    // Candidate stays with current partner; proposer remains free to try next
                    freeProposers.add(proposer);
                }
            }
        }

        return matchesFirstToSecond;
    }
}