package com.example.mindteck.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataModel(val images: Bitmap, val name: String) : Parcelable
