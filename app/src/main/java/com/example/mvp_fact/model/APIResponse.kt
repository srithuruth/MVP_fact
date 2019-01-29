package com.example.mvp_fact.model

import java.time.temporal.TemporalAmount


data class APIResponse(
    val animalId: String, val animalDesc: String, val updatedAt: String,
    val results: List<APIData>
)