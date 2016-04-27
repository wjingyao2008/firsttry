package yang.flexmapping

import java.util

import org.scalatest.FunSuite
import yang.flexmapping.process.FlemxMappingProcesserCreator

/**
  * Created by y28yang on 4/8/2016.
  */
class FlemxMappingProcesserCreatorTest extends FunSuite {

  test("testGenerate") {

//    val xmlString = xml.XML.loadFile(getClass.getResource("/fmFlexMappingFile_REL6.xml").getFile)
    val flemxMappingProcesserCreator=new FlemxMappingProcesserCreator
    flemxMappingProcesserCreator.parseXmlFile(page)
     val events=new java.util.HashMap[String, String]()
    events.put("3gppInstance","field1")
    events.put("3gppInstance","field1")
    events.put("3gppInstance","field1")

  }


  val page = <eventMappings
  xmlns="http://www.nokia.com/schemas/3gpp/Nbi/FmMapping"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.nokia.com/schemas/3gpp/Nbi/FmMapping c3g_fm_flex_mapping.xsd">

    <mapping logName="CREATE ALARM">
      <filter>
        <checkEvent>alarmNew</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x1</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="i" type="string">
        <fromEvent attributeName="alarmNumber"/>
      </attribute>
      <attribute id="j">
        <fromEvent attributeName="alarmText"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="additionalInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="userAddInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="additionalInformation">
        <fromEvent attributeName="additionalInfo"/>
      </attribute>
      <attribute id="userAdditionalInformation">
        <fromEvent attributeName="userAddInfo"/>
      </attribute>
      <attribute id="diagnosticInformation">
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>

    <mapping logName="ACK">
      <filter>
        <checkEvent>alarmAck</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x3</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="ackTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="l">
        <fromEvent attributeName="ackUser"/>
      </attribute>
      <attribute id="m">
        <fromEvent attributeName="ackSystemId"/>
      </attribute>
      <attribute id="n" type="short">
        <fromEvent attributeName="3gppAckStatus"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>

    <mapping logName="UNACK">
      <filter>
        <checkEvent>alarmUnack</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x3</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="ackTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="l">
        <fromEvent attributeName="ackUser"/>
      </attribute>
      <attribute id="m">
        <fromEvent attributeName="ackSystemId"/>
      </attribute>
      <attribute id="n" type="short">
        <fromEvent attributeName="3gppAckStatus"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>

    <mapping logName="CHANGE SEVERITY">
      <filter>
        <checkEvent>alarmSeverityChange</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x2</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>

    <mapping logName="CANCEL ALARM">
      <filter>
        <checkEvent>alarmCancel</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x5</fixedValue>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="cancelTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="y">
        <fromEvent attributeName="cancelUser"/>
      </attribute>
      <attribute id="z">
        <fromEvent attributeName="cancelSystemId"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
    </mapping>

    <mapping logName="UPLOAD ALARM">
      <filter>
        <checkEvent>alarmList</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fromEvent attributeName="uploadedAlarmTypeName"/>
      </typeName>
      <eventName>
        <fromEvent attributeName="3gppEventType"/>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="consecNbr"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="g" type="short">
        <fromEvent attributeName="probableCause"/>
      </attribute>
      <attribute id="h" type="short">
        <fromEvent attributeName="3gppSeverity"/>
      </attribute>
      <attribute id="i" type="string">
        <fromEvent attributeName="alarmNumber"/>
      </attribute>
      <attribute id="j">
        <fromEvent attributeName="alarmText"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="additionalInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="userAddInfo"/>
        <fixedValue>|</fixedValue>
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="additionalInformation">
        <fromEvent attributeName="additionalInfo"/>
      </attribute>
      <attribute id="userAdditionalInformation">
        <fromEvent attributeName="userAddInfo"/>
      </attribute>
      <attribute id="diagnosticInformation">
        <fromEvent attributeName="diagInfo"/>
      </attribute>
      <attribute id="n" type="short">
        <fromEvent attributeName="3gppAckStatus"/>
      </attribute>
      <attribute id="f">
        <fromEvent attributeName="alarmId"/>
      </attribute>
      <conditionalAttributes>
        <filter>
          <checkEvent>alarmListAck</checkEvent>
        </filter>
        <attribute id="k" type="time">
          <fromEvent attributeName="ackTime"/>
        </attribute>
        <attribute id="l">
          <fromEvent attributeName="ackUser"/>
        </attribute>
        <attribute id="m">
          <fromEvent attributeName="ackSystemId"/>
        </attribute>
      </conditionalAttributes>
      <conditionalAttributes>
        <filter>
          <checkEvent>alarmListCancel</checkEvent>
        </filter>
        <attribute id="y">
          <fromEvent attributeName="cancelUser"/>
        </attribute>
        <attribute id="z">
          <fromEvent attributeName="cancelSystemId"/>
        </attribute>
      </conditionalAttributes>
    </mapping>

    <mapping logName="REBUILT ALARM">
      <filter>
        <checkEvent>alarmListRebuilt</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x6</fixedValue>
      </typeName>
      <eventName>
        <fixedValue></fixedValue>
      </eventName>
      <attribute id="e">
        <fromEvent attributeName="systemDN"/>
        <fixedValue>,AlarmIRP=AlarmIRP-1</fixedValue>
      </attribute>
      <attribute id="d">
        <fixedValue>AlarmIRP</fixedValue>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="uniqueNumber"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="x">
        <fromEvent attributeName="alarmText"/>
      </attribute>
      <attribute id="ff">
        <fixedValue>REQUIRED</fixedValue>
      </attribute>
    </mapping>

    <mapping logName="POTENTIAL FAULTY ALARM">
      <filter>
        <checkEvent>potentialFaultyAlarmList</checkEvent>
      </filter>
      <domainName>
        <fromEvent attributeName="irpVersion"/>
      </domainName>
      <typeName>
        <fixedValue>x7</fixedValue>
      </typeName>
      <eventName>
        <fixedValue></fixedValue>
      </eventName>

      <attribute id="e">
        <fromEvent attributeName="3gppInstance"/>
      </attribute>
      <attribute id="d">
        <fromEvent attributeName="3gppClass"/>
      </attribute>
      <attribute id="a" type="long">
        <fromEvent attributeName="uniqueNumber"/>
      </attribute>
      <attribute id="b" type="time">
        <fromEvent attributeName="alarmTime"/>
      </attribute>
      <attribute id="c">
        <fromEvent attributeName="systemDN"/>
      </attribute>
      <attribute id="x">
        <fixedValue>Maintenance</fixedValue>
      </attribute>
    </mapping>
  </eventMappings>

}
