package application.model;


public class ProcessMeasureParticipant {


    private ProcessMeasureParticipantId processMeasureParticipantId;

    private ProcessMeasure processMeasure;

    public ProcessMeasureParticipantId getProcessMeasureParticipantId() {
        return processMeasureParticipantId;
    }

    public void setProcessMeasureParticipantId(ProcessMeasureParticipantId processMeasureParticipantId) {
        this.processMeasureParticipantId = processMeasureParticipantId;
    }

    public ProcessMeasure getProcessMeasure() {
        return processMeasure;
    }

    public void setProcessMeasure(ProcessMeasure processMeasure) {
        this.processMeasure = processMeasure;
    }
}
