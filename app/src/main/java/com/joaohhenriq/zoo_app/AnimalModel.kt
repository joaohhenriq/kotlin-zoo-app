package com.joaohhenriq.zoo_app

class AnimalModel {
    var name: String
    var description: String
    var image: Int

    constructor(
        name: String,
        description: String,
        image: Int
    ) {
        this.name = name
        this.description = description
        this.image = image
    }
}