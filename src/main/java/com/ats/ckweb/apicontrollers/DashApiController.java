package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.report.model.GetDashPieStatusCnt;
import com.ats.ckweb.report.repo.GetDashPieStatusCntRepo;

@RestController
public class DashApiController {

	@Autowired GetDashPieStatusCntRepo dashRepo;
	
	@RequestMapping(value = { "/getAllStatusCount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetDashPieStatusCnt> getGrievanceHeader(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<GetDashPieStatusCnt> res = new ArrayList<GetDashPieStatusCnt>();
		try {
			
			res = dashRepo.getDashStatusCnt(fromDate, toDate);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value = { "/getAllStatusFrCount" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetDashPieStatusCnt> getAllStatusFrCount(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("status") String status) {
		List<GetDashPieStatusCnt> res = new ArrayList<GetDashPieStatusCnt>();
		try {
			
			res = dashRepo.getStatusCntGrpFr(fromDate, toDate, status);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res;
	}
	
	
	
	
	
//	SELECT
//    t1.fr_id,
//    t1.fr_name,
//    COALESCE(t2.status0,0) AS status0,
//    COALESCE(t3.status1,0) AS status1,
//    COALESCE(t4.status2,0) AS status2,
//    COALESCE(t5.status3,0) AS status3,
//    COALESCE(t6.status4,0) AS status4,
//    COALESCE(t7.status5,0) AS status5,
//    COALESCE(t8.status6,0) AS status6,
//    COALESCE(t9.status7,0) AS status7,
//    COALESCE(t10.status8,0) AS status8,
//    COALESCE(t11.status9,0) AS status9
//FROM
//    (
//    SELECT
//        h.order_id,
//        h.fr_id,
//        CONCAT(fr.fr_name, "-", fr.fr_code) AS fr_name,
//        0 AS status0,
//        0 AS status1,
//        0 AS status2,
//        0 AS status3,
//        0 AS status4,
//        0 AS status5,
//        0 AS status6,
//        0 AS status7,
//        0 AS status8,
//        0 AS status9
//    FROM
//        tn_order_header h,
//        m_franchisee fr
//    WHERE
//        h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.fr_id = fr.fr_id AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t1
//LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status0
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 0 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t2
//ON
//    t1.fr_id = t2.fr_id
// LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status1
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 1 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t3
//ON
//    t1.fr_id = t3.fr_id
//LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status2
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 2 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t4
//ON
//    t1.fr_id = t4.fr_id
//    LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status3
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 3 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t5
//ON
//    t1.fr_id = t5.fr_id
//    
//    LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status4
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 4 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t6
//ON
//    t1.fr_id = t6.fr_id
//    LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status5
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 5 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t7
//ON
//    t1.fr_id = t7.fr_id
//   LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status6
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 6 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t8
//ON
//    t1.fr_id = t8.fr_id
//   LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status7
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 7 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t9
//ON
//    t1.fr_id = t9.fr_id
//   LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status8
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 8 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t10
//ON
//    t1.fr_id = t10.fr_id
//     LEFT JOIN(
//    SELECT h.order_id,
//        h.fr_id,
//        COUNT(h.order_status) AS status9
//    FROM
//        tn_order_header h
//    WHERE
//        h.order_status = 9 AND h.delivery_date BETWEEN '2020-08-01' AND '2020-08-29' AND h.del_status = 0
//    GROUP BY
//        h.fr_id
//) t11
//ON
//    t1.fr_id = t11.fr_id
	
}
