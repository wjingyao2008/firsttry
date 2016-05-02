package home.yang.dataflow

import java.util.{Calendar, Date}

import home.yang.dataflow.datahold.DateTimeData
import home.yang.dataflow.filtercreator.{DateFilterCreator, StringFilterCreator}
import org.scalatest.{FunSuite, Matchers}

/**
  * Created by Administrator on 2016/5/2 0002.
  */
class FilterCreatorTest extends FunSuite with Matchers{

  test("testCreate") {
    val simpleFilter="$e=='ff'"
    val filterCreator=new StringFilterCreator
    val filter=filterCreator.create("aName","ver1.3","==")
    filter.createString("ver1.2") shouldBe false
    filter.createString("ver1.3") shouldBe true
  }

  test("testCreate Data <=") {
    val filterCreator=new DateFilterCreator
    val date1=new Date
    val strDate=DateTimeData.toString(date1)
    val filter=filterCreator.create("aName",strDate,"<=")

    val hourAfterDate=genDate(1)
    filter.createDate(hourAfterDate) shouldBe false

    val hourBeforeDate2=genDate(-2)
    filter.createDate(hourBeforeDate2) shouldBe true
  }



  test("testCreate Data >") {
    val filterCreator=new DateFilterCreator
    val date1=new Date
    val strDate=DateTimeData.toString(date1)
    val filter=filterCreator.create("aName",strDate,">")

    val hourAfterDate=genDate(1)
    filter.createDate(hourAfterDate) shouldBe true

    val hourBeforeDate=genDate(-2)
    filter.createDate(hourBeforeDate) shouldBe false
  }


  def genDate(addHour:Int)={
    val calendar=Calendar.getInstance
    calendar.add(Calendar.HOUR,addHour)
    calendar.getTime
  }


}
