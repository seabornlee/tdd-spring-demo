package tdd.spring.demo;

import java.util.Objects;

public class ApplicationPO {
    public static final int STATUS_APPROVED = 1;
    public static final int STATUS_SUBMITTED = 0;
    private int status;
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationPO that = (ApplicationPO) o;
        return status == that.status &&
                id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, id);
    }

    public int getStatus() {
        return status;
    }

    boolean isApproved() {
        return getStatus() == STATUS_APPROVED;
    }

    void setSubmitted() {
        setStatus(STATUS_SUBMITTED);
    }

    void setApproved() {
        setStatus(STATUS_APPROVED);
    }
}
