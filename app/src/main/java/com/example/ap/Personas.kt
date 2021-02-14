package com.example.ap

data class Personas(
    var gender: String,
    var name: String,
    var location: Location,
    var email: String,
    var login: Login,
    var dob: Dob,
    var registered: Registered,
    var phone: String,
    var cell: String,
    var id: List<String>?,
    var picture: Id,
    var nat: Picture

)
data class Location(
    var street: Street,
    var city: String,
    var country: String,
    var postcode:Int,
    var coordinates: Coordinates,
    var timezone: Timezone
)

data class Street(
    var number: Int,
    var name: String
)

data class Coordinates(
    var latitude:Double,
    var longitude:Double
)

data class Timezone(
    var offset: String,
    var description:String
)

data class Login(
    var uuid:String,
    var username:String,
    var password:String,
    var salt:String,
    var md5:String,
    var sha1:String,
    var sha256:String
)

data class Dob(
    var date:String,
    var age:Int
)

data class Registered(
    var date:String,
    var age:Int
)

data class Id(
    var name:String,
    var value:String
)

data class Picture(
    var large:String,
    var medium:String,
    var thumbnail:String
)