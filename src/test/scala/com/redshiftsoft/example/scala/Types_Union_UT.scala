package com.redshiftsoft.example.scala

import com.redshiftsoft.example.scalatest.BaseSpec

/**
 * https://docs.scala-lang.org/scala3/reference/new-types/union-types.html
 */
class Types_Union_UT extends BaseSpec {

  class Hash(val name: String)

  trait ID

  case class UserName(name: String) extends ID

  case class Password(hash: Hash) extends ID

  def help(id: UserName | Password): String =
    val user: String = id match
      case UserName(name) => name
      case Password(hash) => hash.name
    user

  "either class" should "be a valid argument to help" in {
    val u1 = UserName("username_username")
    val p1 = Password(Hash("password_username"))

    help(u1) should be("username_username")
    help(p1) should be("password_username")
  }

}
