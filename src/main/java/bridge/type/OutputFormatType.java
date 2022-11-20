package bridge.type;

public enum OutputFormatType {
    START_BRACKET("[ "),
    SEPARATOR(" | "),
    SPACE(" "),
    END_BRACKET(" ]");

    private final String outputFormat;

    OutputFormatType(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }
}
