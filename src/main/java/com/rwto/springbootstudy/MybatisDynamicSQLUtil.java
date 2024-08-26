package com.rwto.springbootstudy;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.scripting.xmltags.XMLScriptBuilder;
import org.apache.ibatis.session.Configuration;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author renmw
 * @create 2024/3/26 10:45
 **/
public class MybatisDynamicSQLUtil {
    private static Configuration configuration = new Configuration();

    /**
     * 解析动态sql
     * @param sourceSql
     * @param params
     * @return
     */
    public static String parsingDynamicSql(String sourceSql, Map<String,Object> params){
        /*获取document*/
        sourceSql = "<select>" + sourceSql + "</select>";
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new InputSource(new StringReader(sourceSql)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XPathParser xPathParser = new XPathParser(document, true, configuration.getVariables(), new XMLMapperEntityResolver());

        /*解析xml。获取xnode*/
        XNode xNode = new XNode(xPathParser, document.getFirstChild(), configuration.getVariables());

        /*获取SQLNode*/
        XMLScriptBuilder xmlScriptBuilder = new XMLScriptBuilder(configuration, xNode);

        SqlSource sqlSource = xmlScriptBuilder.parseScriptNode();
        String sql = null;
        if(sqlSource instanceof DynamicSqlSource){
            SqlNode sqlNode = null;
            try {
                Field rootSqlNode = DynamicSqlSource.class.getDeclaredField("rootSqlNode");
                rootSqlNode.setAccessible(true);
                sqlNode = (SqlNode) rootSqlNode.get(sqlSource);
                HashMap<Object, Object> paramsWrapper = new HashMap<>();
                paramsWrapper.put("params", params);
                DynamicContext context = new DynamicContext(configuration, paramsWrapper);
                sqlNode.apply(context);
                sql = context.getSql();
            } catch (NoSuchFieldException | IllegalAccessException e) {
            }
        }else {
            sql = sqlSource.getBoundSql(null).getSql();
        }

        /*生成sql*/
        return sql;
    }
}
