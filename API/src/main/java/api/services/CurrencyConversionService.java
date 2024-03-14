package api.services;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import api.dto.CurrencyConversionDto;

public interface CurrencyConversionService {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionDto getConversion(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity);
}
