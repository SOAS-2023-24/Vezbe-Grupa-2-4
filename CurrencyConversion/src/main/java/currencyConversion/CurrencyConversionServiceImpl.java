package currencyConversion;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.dto.CurrencyConversionDto;
import api.dto.CurrencyExchangeDto;
import api.services.CurrencyConversionService;

@RestController
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	private RestTemplate template = new RestTemplate();
	
	@Override
	public CurrencyConversionDto getConversion(String from, String to, BigDecimal quantity) {
		HashMap<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyExchangeDto> response = template.
		getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
			CurrencyExchangeDto.class, uriVariables);
		
		return exchangeToConversion(response.getBody(), quantity);
	}
	
	public CurrencyConversionDto exchangeToConversion(CurrencyExchangeDto dto, BigDecimal quantity) {
		return new CurrencyConversionDto(dto, quantity,  
				quantity.multiply(dto.getExchangeValue()), dto.getTo());		
	}
	
	
	
	
	
	
	
	

}
