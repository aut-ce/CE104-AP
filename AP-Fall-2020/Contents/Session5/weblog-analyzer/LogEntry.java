/**
 * Store the data from a single line of a
 * web-server log file.
 * Individual fields are made available via
 * accessors such as getHour() and getMinute().
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogEntry implements Comparable<LogEntry>
{
    // Where the data values extracted from a single
    // log line are stored.
    private int[] dataValues;
    // At which index in dataValues the different fields
    // from a log line are stored.
    private static final int YEAR = 0, MONTH = 1, DAY = 2,
                             HOUR = 3, MINUTE = 4;
                      
    /**
     * Decompose a log line so that the individual fields
     * are available.
     * @param logline A single line from the log.
     */
    public LogEntry(String logline)
    {
        // The array to store the data for a single line.
        dataValues = new int[5];
        // Break up the log line.
        LoglineTokenizer tokenizer = new LoglineTokenizer();
        tokenizer.tokenize(logline,dataValues);
    }
    
    /**
     * @return The hour field from the log line.
     */
    public int getHour()
    {
        return dataValues[HOUR];
    }

    /**
     * @return The minute field from the log line.
     */
    public int getMinute()
    {
        return dataValues[MINUTE];
    }
    
    /**
     * Create a string representation of the data.
     * This is not necessarily identical with the
     * text of the original log line.
     * @return A string representing the data of this entry.
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        for(int value : dataValues) {
           // Prefix a leading zero on single digit numbers.
            if(value < 10) {
                buffer.append('0');
            }
            buffer.append(value);
            buffer.append(' ');
        }
        // Drop any trailing space.
        return buffer.toString().trim();
    }
    
    /**
     * Compare the date/time combination of this log entry
     * with another.
     * @param otherEntry The other entry to compare against.
     * @return A negative value if this entry comes before the other.
     *         A positive value if this entry comes after the other.
     *         Zero if the entries are the same.
     */
    public int compareTo(LogEntry otherEntry)
    {
        if(otherEntry == this) {
            // They are the same object.
            return 0;
        }
        else {
            // Compare corresponding fields.
            for(int i = 0; i < dataValues.length; i++) {
                int difference = dataValues[i] - otherEntry.dataValues[i];
                if(difference != 0) {
                    return difference;
                }
            }
            // No value is different, so the two entries represent
            // identical times.
            return 0;
        }
    }
}