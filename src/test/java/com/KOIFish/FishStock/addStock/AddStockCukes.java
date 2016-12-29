package com.KOIFish.FishStock.addStock;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/main/resources/addstock.feature"})
public class AddStockCukes {}
