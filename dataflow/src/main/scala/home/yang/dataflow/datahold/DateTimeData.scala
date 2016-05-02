package home.yang.dataflow.datahold

import java.util.Date

import home.yang.dataflow.{DataHolder, ValueMapper}
import org.apache.commons.lang3.time.FastDateFormat

/**
  * Created by Administrator on 2016/5/2 0002.
  */

class DateTimeData(id: String, value: String) extends DataHolder(id, value) {

  var date :java.util.Date= null
  override def parse: Unit = {
    try{
      date =  DateTimeData.fastParseTime(value)
    }catch {
      case parex: java.text.ParseException=> date=new Date
    }
  }
  override def mapTo(outValueCreator: ValueMapper): Any = {
    outValueCreator.createDate(date)
  }
}

object DateTimeData {
  private val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
  private val fastDateParser = FastDateFormat.getInstance(DATE_FORMAT)

  def fastParseTime(value: String) = {
    fastDateParser.parse(value)
  }

  def toString(value:Date):String={
    fastDateParser.format(value)
  }
}
