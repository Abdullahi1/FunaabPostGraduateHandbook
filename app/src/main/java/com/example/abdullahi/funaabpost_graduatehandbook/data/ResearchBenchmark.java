package com.example.abdullahi.funaabpost_graduatehandbook.data;

public class ResearchBenchmark {

    public static final String benchmark_id = "id";
    public static final String benchmark_name = "benchmark_name";
    public static final String benchmark_program = "program_id";

    private final int id;
    private final String benchmarkName;

    public ResearchBenchmark(int id, String durationName) {
        this.id = id;
        this.benchmarkName = durationName;
    }

    public int getId() {
        return id;
    }

    public String getBenchmarkName() {
        return benchmarkName;
    }
}
