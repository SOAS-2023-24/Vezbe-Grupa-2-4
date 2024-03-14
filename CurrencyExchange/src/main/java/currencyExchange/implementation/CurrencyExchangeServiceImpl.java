package currencyExchange.implementation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import api.dto.CurrencyExchangeDto;
import api.services.CurrencyExchangeService;
import currencyExchange.model.CurrencyExchangeModel;
import currencyExchange.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepository repo;

	@Override
	public CurrencyExchangeDto getExchange(String from, String to) {
		return convertFromModelToDto(repo.findByFromAndTo(from, to));
	}
	
	public CurrencyExchangeDto convertFromModelToDto(CurrencyExchangeModel model) {
		return new 
		CurrencyExchangeDto(model.getFrom(), model.getTo(), model.getExchangeValue());
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
