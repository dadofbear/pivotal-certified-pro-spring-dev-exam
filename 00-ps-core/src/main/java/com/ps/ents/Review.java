package com.ps.ents;

import com.ps.base.AbstractEntity;
import com.ps.base.ReviewGrade;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;

/**
 * Created by iuliana.cosmina on 2/7/16.
 */
public class Review extends AbstractEntity {

    @OneToOne
    @Column(name = "REQUEST_ID")
    private Request request;

    @OneToOne
    @Column(name = "RESPONSE_ID")
    private Response response;

    @NotEmpty
    @Column
    @Enumerated(EnumType.ORDINAL)
    private ReviewGrade grade;

    @Size(max = 500)
    @NotEmpty
    @Column
    private String details;

    //required by JPA
    public Review() {
        super();
    }

    public ReviewGrade getGrade() {
        return grade;
    }

    public void setGrade(ReviewGrade grade) {
        this.grade = grade;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Review review = (Review) o;

        if (request != null ? !request.equals(review.request) : review.request != null) return false;
        if (response != null ? !response.equals(review.response) : review.response != null) return false;
        return grade == review.grade;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (response != null ? response.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Review[request_id='%,.2f', response_id='%,.2f', grade='%s', details='%s']",
                request.getId(), response.getId(), grade.toString(), details);
    }
}