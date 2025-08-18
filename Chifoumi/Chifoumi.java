public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        if (chifoumiAction == null) {
            throw new IllegalArgumentException("chifoumiAction must not be null");
        }
        switch (chifoumiAction) {
            case ROCK:
                return ChifoumiAction.SCISSOR; // Rock beats Scissor
            case PAPER:
                return ChifoumiAction.ROCK;    // Paper beats Rock
            case SCISSOR:
                return ChifoumiAction.PAPER;   // Scissor beats Paper
            default:
                throw new IllegalArgumentException("Invalid action: " + chifoumiAction);
        }
    }
}
