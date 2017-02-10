package com.codecool.hccrm.logging;

public enum LogFormatter {
    FORMAT(">>>>> ");
    private final String formatter;

    LogFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getFormatter() {
        return this.formatter;
    }
}
