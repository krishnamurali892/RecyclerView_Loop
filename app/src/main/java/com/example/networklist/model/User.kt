package com.example.networklist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("id")
    @Expose
    var id: String?= null

    @SerializedName("FirstName")
    @Expose
    var firstName: String?= null
    @SerializedName("LastName")
    @Expose
    var lastName: String?= null
    @SerializedName("Email")
    @Expose
    var email: String?= null
    @SerializedName("ContactNo")
    @Expose
    var contactNo: String?= null
    @SerializedName("DOB")
    @Expose
    var dOB: String?= null
    @SerializedName("Image")
    @Expose
    var image: String?= null
}