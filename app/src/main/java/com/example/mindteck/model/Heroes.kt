package com.example.mindteck.model

import android.media.Image
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Heroes(val images: String, val name: String) : Parcelable

/*
@Parcelize
class Country(val images: Image, val name: String) : Parcelable

@Parcelize

class Fruits(val images: Image, val name: String) : Parcelable*/
