package home.yang.dataflow.datahold

import home.yang.dataflow.SimpleData
import home.yang.dataflow.dataholdcreator.{IntCreator, StringCreator}
import home.yang.dataflow.filter.{IntFilter, StringFilter}
import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class SimpleDataHolderCreatorFactory$Test extends FunSuite with Matchers{

  test("testGetOrWithDefault") {
    val intCreator=new IntCreator
    val dataHolder=intCreator.create("yangTYPE","35")
    dataHolder.parse
    val intFilter=new IntFilter("yangTYPE",_ > 20)
    dataHolder.mapTo(intFilter) shouldBe true
  }
  test("test filter of string") {
    val stringHolderCreator=new StringCreator
    val dataHolder=stringHolderCreator.create("yangTYPE","35")
    dataHolder.parse
    val stringFilter=new StringFilter("yangTYPE",_ == "34")
    dataHolder.mapTo(stringFilter) shouldBe false

  }

  test("test filter of Data") {
    val intCreator=new IntCreator
    val dataHolder=intCreator.create("alarmId","35")
    dataHolder.parse

    val stringCreator=new StringCreator
    val dataHolder2=stringCreator.create("domainName","35")
    dataHolder2.parse

    val data=new SimpleData(Map(dataHolder.id->dataHolder,dataHolder2.id->dataHolder2))

     val filter="$domainName==35"

//    val stringFilter=new StringFilter("yangTYPE",_ == "34")
//    dataHolder.toOuterValue(stringFilter) shouldBe false

  }


  val simpleFilter="$e=='ff'"
  val filterExample="($.header.fixed_header.event_type.domain_name=='32.303 V6.3' or ($.header.fixed_header.event_type.domain_name=='32.111 V6.2') or $.header.fixed_header.event_type.domain_name=='32.603 V6.3.1' or $.header.fixed_header.event_type.domain_name=='32.346-A V10.0' or $.header.fixed_header.event_type.domain_name=='32.363 V6.3' or $.header.fixed_header.event_type.domain_name=='32.663 V6.4' or $.header.fixed_header.event_type.domain_name=='32.353 V6.2') "
}
