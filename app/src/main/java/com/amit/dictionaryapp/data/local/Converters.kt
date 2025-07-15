package com.amit.dictionaryapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.amit.dictionaryapp.data.utils.GsonParser
import com.amit.dictionaryapp.domain.model.MeaningModel
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: GsonParser
) {
    @TypeConverter
    fun fromMeaningJson(json:String):List<MeaningModel>{
        return jsonParser.fromJson<ArrayList<MeaningModel>>(
            json,
            object : TypeToken<ArrayList<MeaningModel>>(){}.type
            ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningJson(meaningModelList: List<MeaningModel>): String{
        return jsonParser.toJson(meaningModelList,
            object : TypeToken<ArrayList<MeaningModel>>(){}.type
            ) ?: "[]"
    }

}