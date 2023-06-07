<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>Login fail_with excel</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>588a40c9-2567-4a84-9e51-e60fd9691731</testSuiteGuid>
   <testCaseLink>
      <guid>93c9dc4a-6c77-4c29-9f7d-71945891d774</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Test_Web/Login fail_with excel/a_navigative login</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
   </testCaseLink>
   <testCaseLink>
      <guid>800de19d-0d4a-44dd-8049-5c84d407bca5</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Test_Web/Login fail_with excel/multi login</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>773e6e88-1acb-4cd6-927e-f8bc69d936a6</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>1-7</value>
         </iterationEntity>
         <testDataId>Data Files/login fail</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>773e6e88-1acb-4cd6-927e-f8bc69d936a6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>EMAIL</value>
         <variableId>ffc1dbcd-db3b-4a15-aa93-5a3686763009</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>773e6e88-1acb-4cd6-927e-f8bc69d936a6</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>PASSWORD</value>
         <variableId>15e32ae1-a5cb-4779-8dfd-7c4948d76f1e</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
