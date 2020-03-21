package com.kedar.dependencyinjection.api.model

data class UsersDetail(
    val page: Int,
    val per_page:Int,
    val total_pages:Int,
    val data:List<User>,
    val ad:Ad
)