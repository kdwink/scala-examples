package com.redshiftsoft.example.scala

import com.redshiftsoft.example.scalatest.BaseSpec

class Control_While_UT extends BaseSpec:

  "do while" should "work as expected" in:
    var i = 0

    while i < 9 do
      i += 1

    i should be(9)


