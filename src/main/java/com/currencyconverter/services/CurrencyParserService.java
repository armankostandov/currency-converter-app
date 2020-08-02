package com.currencyconverter.services;

import com.currencyconverter.model.Currency;
import org.springframework.stereotype.Service;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class CurrencyParserService {

    public static Set<Currency> getCurrency(String url) throws DOMException, XPathExpressionException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        try {
            doc = builder.parse(url);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();

        XPathExpression nameExpr = xpath.compile(
                "/ValCurs/Valute/Name");
        XPathExpression codeExpr = xpath.compile(
                "/ValCurs/Valute/CharCode");
        XPathExpression valueExpr = xpath.compile(
                "/ValCurs/Valute/Value");
        XPathExpression nominalExpr = xpath.compile(
                "/ValCurs/Valute/Nominal");

        NodeList nameNodes = (NodeList) nameExpr.evaluate(doc, XPathConstants.NODESET);
        NodeList codeNodes = (NodeList) codeExpr.evaluate(doc, XPathConstants.NODESET);
        NodeList valueNodes = (NodeList) valueExpr.evaluate(doc, XPathConstants.NODESET);
        NodeList nominalNodes = (NodeList) nominalExpr.evaluate(doc, XPathConstants.NODESET);

        Set<Currency> currencies = new HashSet<>();

        for (int i = 0; i < nameNodes.getLength(); i++) {
            Currency currency = new Currency();
            currency.setName(nameNodes.item(i).getTextContent());
            currency.setCode(codeNodes.item(i).getTextContent());
            currency.setValue(Double.parseDouble(valueNodes.item(i).getTextContent().replace(",", ".")));
            currency.setNominal(Integer.parseInt(nominalNodes.item(i).getTextContent()));
            currency.setDate(LocalDate.now());
            currencies.add(currency);
        }

        return currencies;
    }
}
