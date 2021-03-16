package com.joaohhenriq.zoo_app

class AnimalModel {
    var name: String
    var description: String
    var image: Int
    var isDangerous: Boolean = false

    constructor(
        name: String,
        description: String,
        image: Int,
        isDangerous: Boolean
    ) {
        this.name = name
        this.description = description
        this.image = image
        this.isDangerous = isDangerous
    }
}