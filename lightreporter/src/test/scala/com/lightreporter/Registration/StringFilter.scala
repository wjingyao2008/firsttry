package com.lightreporter.registration

import com.lightreporter.filterfunc.Filter

/**
  * Created by y28yang on 5/4/2016.
  */
class StringFilter(val shouldBe:String) extends Filter[String]{
  override def isPass(msg: String): Boolean = {
    msg.equals(shouldBe)
  }
}
