package com.capitalone.dashboard.model;

import java.util.HashMap;
import java.util.Map;

public class PipelineCommit {
    private Commit commit;
    private PipelineStageType currentStage;
    private Map<PipelineStageType, Long> processedTimestamps = new HashMap<>();

    public PipelineCommit(Commit commit) {
        this.commit = commit;
    }

    public PipelineCommit(Commit commit, Map<PipelineStageType, Long> processedTimestamps) {
        this.commit = commit;
        this.processedTimestamps = processedTimestamps;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Map<PipelineStageType, Long> getProcessedTimestamps() {
        return processedTimestamps;
    }

    public void setProcessedTimestamps(Map<PipelineStageType, Long> processedTimestamps) {
        this.processedTimestamps = processedTimestamps;
    }

    public PipelineStageType getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(PipelineStageType currentStage) {
        this.currentStage = currentStage;
    }

    public void addNewPipelineProcessedTimestamp(PipelineStageType pipelineStageType, Long timestamp){
        getProcessedTimestamps().put(pipelineStageType, timestamp);
    }

    public void updateCurrentStage(PipelineStageType currentStage, Long timestamp) {
        this.currentStage = currentStage;
        this.addNewPipelineProcessedTimestamp(currentStage, timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PipelineCommit that = (PipelineCommit) o;

        return commit.scmRevisionNumber.equals(that.commit.scmRevisionNumber);
    }

    @Override
    public int hashCode() {
        return commit.hashCode();
    }
}
