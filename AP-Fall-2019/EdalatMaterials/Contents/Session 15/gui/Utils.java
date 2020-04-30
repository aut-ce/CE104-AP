
public class Utils {

    /**
     * Prints some statistics about the JVM memory status;
     * including free-space, used-space, current-size, and max-size.
     */
    public static void printMemoryStats() {
        long free = Runtime.getRuntime().freeMemory();
        long total = Runtime.getRuntime().totalMemory();
        long max = Runtime.getRuntime().maxMemory();
        StringBuilder memory = new StringBuilder();
        memory.append(String.format("\n  Free Memory  : %6.2f MB  (%04.1f%%)\n"
                        + "  Used Memory  : %6.2f MB  (%04.1f%%)\n"
                        + "  Current Heap : %6.2f MB  (%04.1f%%)\n"
                        + "  Max Available Memory : %6.2f MB\n",
                (float) free / (1024 * 1024), (float) (free * 100) / total,
                (float) (total - free) / (1024 * 1024), (float) 100 * (total - free) / total,
                (float) total / (1024 * 1024), (float) (total * 100) / max,
                (float) max / (1024 * 1024)));
        System.out.println(memory.toString());
    }

}
