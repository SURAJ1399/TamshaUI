package net.developers.ttamasha.model

data class GetEventsItem(
    val chatURL: String,
    val delay: Int,
    val entryFee: Int,
    val eventHost: String,
    val eventID: String,
    val eventName: String,
    val eventTime: Long,
    val hostID: String,
    val imageURL: String,
    val paymentLink: String,
    val profileURL: String,
    val srcURL: String
)