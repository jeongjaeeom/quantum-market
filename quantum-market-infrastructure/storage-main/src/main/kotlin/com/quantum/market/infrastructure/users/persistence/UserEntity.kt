package com.quantum.market.infrastructure.users.persistence

import com.quantum.market.infrastructure.common.persistence.BaseEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
internal class UserEntity(
    @Id val id: UUID,
    val name: String
) : BaseEntity()
