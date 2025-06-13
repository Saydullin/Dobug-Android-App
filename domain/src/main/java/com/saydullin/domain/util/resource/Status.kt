package com.saydullin.domain.util.resource

object Status {

    object Success: StatusResource {
        override val code = 1
        override val description = ""
    }

    object Unknown: StatusResource {
        override val code = 2
        override val description = ""
    }

    object UNAUTHORIZED: StatusResource {
        override val code = 401
        override val description = ""
    }

    object PostServerError: StatusResource {
        override val code = 3
        override val description = ""
    }

    object PostDatabaseSelectError: StatusResource {
        override val code = 4
        override val description = ""
    }

    object PostDatabaseInsertError: StatusResource {
        override val code = 5
        override val description = ""
    }

    object PostDatabaseDeleteError: StatusResource {
        override val code = 6
        override val description = ""
    }

    object LOGIN: StatusResource {
        override val code = 7
        override val description = ""
    }

    object SIGNUP: StatusResource {
        override val code = 8
        override val description = ""
    }

    object LOGOUT: StatusResource {
        override val code = 9
        override val description = ""
    }

}