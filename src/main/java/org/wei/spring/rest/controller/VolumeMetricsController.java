package org.wei.spring.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wei.spring.rest.domain.VolumeMetrics;
import org.wei.spring.rest.utils.PaymentDataService;

@Controller
@RequestMapping(value = "/restapi/charts")
public class VolumeMetricsController {

	@RequestMapping(value = "/{option}/volume.json", method = RequestMethod.GET)
	@ResponseBody
	public List<VolumeMetrics> getNumberMetrics(
			@PathVariable String option,
			@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate) {

		if (startDate == null || startDate.isEmpty()) {
			startDate = "";
		}

		if (endDate == null || endDate.isEmpty()) {
			endDate = "";
		}

		return PaymentDataService.getVolumeMetrics(startDate, endDate, option);
	}

}
