
package com.app.logintest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("birth_date")
    @Expose
    private String birthDate;
    @SerializedName("address_1")
    @Expose
    private String address1;
    @SerializedName("address_2")
    @Expose
    private String address2;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("post_code")
    @Expose
    private String postCode;
    @SerializedName("roll")
    @Expose
    private Integer roll;
    @SerializedName("registration_type")
    @Expose
    private String registrationType;
    @SerializedName("social_value")
    @Expose
    private String socialValue;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("is_delete")
    @Expose
    private Integer isDelete;
    @SerializedName("is_verified")
    @Expose
    private Integer isVerified;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pob")
    @Expose
    private String pob;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("agreement_ticket")
    @Expose
    private String agreementTicket;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("photo_id")
    @Expose
    private Integer photoId;
    @SerializedName("resume")
    @Expose
    private String resume;
    @SerializedName("resume_id")
    @Expose
    private Integer resumeId;
    @SerializedName("offer_id")
    @Expose
    private Integer offerId;
    @SerializedName("nda")
    @Expose
    private String nda;
    @SerializedName("loi")
    @Expose
    private String loi;
    @SerializedName("nda_document_url")
    @Expose
    private String ndaDocumentUrl;
    @SerializedName("loi_document_url")
    @Expose
    private String loiDocumentUrl;
    @SerializedName("col_document_url")
    @Expose
    private String colDocumentUrl;
    @SerializedName("nda_url")
    @Expose
    private String ndaUrl;
    @SerializedName("loi_url")
    @Expose
    private String loiUrl;
    @SerializedName("loi_aggr_id")
    @Expose
    private String loiAggrId;
    @SerializedName("nda_aggr_id")
    @Expose
    private String ndaAggrId;
    @SerializedName("col_aggr_id")
    @Expose
    private String colAggrId;
    @SerializedName("col_url")
    @Expose
    private String colUrl;
    @SerializedName("col")
    @Expose
    private String col;
    @SerializedName("signoffer")
    @Expose
    private String signoffer;
    @SerializedName("token")
    @Expose
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    public String getSocialValue() {
        return socialValue;
    }

    public void setSocialValue(String socialValue) {
        this.socialValue = socialValue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAgreementTicket() {
        return agreementTicket;
    }

    public void setAgreementTicket(String agreementTicket) {
        this.agreementTicket = agreementTicket;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public String getNda() {
        return nda;
    }

    public void setNda(String nda) {
        this.nda = nda;
    }

    public String getLoi() {
        return loi;
    }

    public void setLoi(String loi) {
        this.loi = loi;
    }

    public String getNdaDocumentUrl() {
        return ndaDocumentUrl;
    }

    public void setNdaDocumentUrl(String ndaDocumentUrl) {
        this.ndaDocumentUrl = ndaDocumentUrl;
    }

    public String getLoiDocumentUrl() {
        return loiDocumentUrl;
    }

    public void setLoiDocumentUrl(String loiDocumentUrl) {
        this.loiDocumentUrl = loiDocumentUrl;
    }

    public String getColDocumentUrl() {
        return colDocumentUrl;
    }

    public void setColDocumentUrl(String colDocumentUrl) {
        this.colDocumentUrl = colDocumentUrl;
    }

    public String getNdaUrl() {
        return ndaUrl;
    }

    public void setNdaUrl(String ndaUrl) {
        this.ndaUrl = ndaUrl;
    }

    public String getLoiUrl() {
        return loiUrl;
    }

    public void setLoiUrl(String loiUrl) {
        this.loiUrl = loiUrl;
    }

    public String getLoiAggrId() {
        return loiAggrId;
    }

    public void setLoiAggrId(String loiAggrId) {
        this.loiAggrId = loiAggrId;
    }

    public String getNdaAggrId() {
        return ndaAggrId;
    }

    public void setNdaAggrId(String ndaAggrId) {
        this.ndaAggrId = ndaAggrId;
    }

    public String getColAggrId() {
        return colAggrId;
    }

    public void setColAggrId(String colAggrId) {
        this.colAggrId = colAggrId;
    }

    public String getColUrl() {
        return colUrl;
    }

    public void setColUrl(String colUrl) {
        this.colUrl = colUrl;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getSignoffer() {
        return signoffer;
    }

    public void setSignoffer(String signoffer) {
        this.signoffer = signoffer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
