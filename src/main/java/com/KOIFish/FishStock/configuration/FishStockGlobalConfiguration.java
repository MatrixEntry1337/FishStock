package com.KOIFish.FishStock.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={FishStockBackEndConfiguration.class, FishStockMiddleTeirConfiguration.class})
public class FishStockGlobalConfiguration {

}
