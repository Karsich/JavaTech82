package com.example.demo.modules;

public interface Module {
    boolean isSupported(String format);
    String getDescription();
    void Execute(String file);
}
