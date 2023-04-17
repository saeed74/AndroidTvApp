package com.arianamnesh.donetvtest

class Movie(id: Long, img: Int) {

    val id = id
    val img = img

    override fun toString(): String {
        return "Movie {" +
                " 'id': $id," +
                " 'img': '$img' }"
    }
}