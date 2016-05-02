package home.yang.dataflow.datahold

import java.lang.{Boolean, Short}
import java.util.Date

import org.apache.commons.lang3.time.FastDateFormat

/**
  * Created by y28yang on 4/10/2016.
  */
abstract class DataHolder(val id: String, val value: String) {

  def toOuterValue(outValueCreator: ValueGen): Any

  def parse


}


class StringData(id: String, value: String) extends DataHolder(id, value) {

  var typeValue = ""

  override def toOuterValue(outValueCreator: ValueGen): Any = {
    outValueCreator.createString(typeValue)
  }

  override def parse: Unit = {
    typeValue = value
  }
}


class IntData(id: String, value: String) extends DataHolder(id, value) {

  var int = 0

  override def parse: Unit = {
    int = Integer.parseInt(value)
  }

  override def toOuterValue(outValueCreator: ValueGen): Any = outValueCreator.createInt(int)
}


class UnsignIntData(id: String, value: String) extends DataHolder(id, value) {

  var unsignInt: Int = 0

  override def parse: Unit = {
    unsignInt = Integer.parseUnsignedInt(value)
  }

  override def toOuterValue(outValueCreator: ValueGen): Any = {
    outValueCreator.createInt(unsignInt)
  }
}

class ShortData(id: String, value: String) extends DataHolder(id, value) {

  var short: Short = 0.toShort


  override def parse: Unit = {
    short = Short.parseShort(value)
  }


  override def toOuterValue(outValueCreator: ValueGen): Any = {
    outValueCreator.createShort(short)
  }
}


class BooleanData(id: String, value: String) extends DataHolder(id, value) {

  var booleanVal =false

  override def parse: Unit = {
    booleanVal =  Boolean.valueOf(value)
  }


  override def toOuterValue(outValueCreator: ValueGen): Any= {
    outValueCreator.createBoolean(booleanVal)
  }
}

//class UnsignShortData(id: String, value: String) extends DataHolder(id, value) {
//
//  var usignInt = Short.parseShort(value)
//
//  override def parse: Unit = {
//    usignInt =  Short.parseShort(value)
//  }
//
//  override def toOuterValue(outValueCreator: ValueGen): Any = {
//    outValueCreator.createShort(usignInt)
//  }
//
//}

class DateTimeData(id: String, value: String) extends DataHolder(id, value) {

  var date :java.util.Date= null
  override def parse: Unit = {
    try{
      date =  DateTimeData.fastParseTime(value)
    }catch {
      case parex: java.text.ParseException=> date=new Date
    }
  }
  override def toOuterValue(outValueCreator: ValueGen): Any = {
    outValueCreator.createDate(date)
  }
}

object DateTimeData {
  private val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
  private val fastDateParser = FastDateFormat.getInstance(DATE_FORMAT)

  def fastParseTime(value: String) = {
    fastDateParser.parse(value)

  }
}
