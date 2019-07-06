package com.kb.csrm.rfConnction.controller;

import com.kb.csrm.rfConnction.dto.RFConnectionDto;
import com.kb.csrm.rfConnction.service.IRFConnectionService;
import com.kb.csrm.util.BaseController;
import com.kb.csrm.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/rfConnection")
public class RFConnectionController extends BaseController {

    @Autowired
    private IRFConnectionService rfConnectionService;

    @RequestMapping("/getRFConnectionById")
    @ResponseBody
    public ResponseData getRFConnectionById(@RequestBody Integer rfConnectionId, HttpServletRequest request){

        return new ResponseData(rfConnectionService.getRFConnectionById(rfConnectionId));
    }

    @RequestMapping("/getRFConnectionByRoleName")
    @ResponseBody
    public ResponseData getRFConnectionByRoleName(@RequestBody String roleName, HttpServletRequest request){
        return new ResponseData(rfConnectionService.getRFConnectionByRoleName(roleName));
    }

    @RequestMapping("/updateRFConnection")
    @ResponseBody
    public ResponseData updateRFConnection(@RequestBody RFConnectionDto rfConnectionDto, HttpServletRequest request){
        rfConnectionService.updateRFConnection(rfConnectionDto);
        return new ResponseData(true);
    }

    @RequestMapping("/deleteRFConnection")
    @ResponseBody
    public ResponseData deleteRFConnection(@RequestBody RFConnectionDto rfConnectionDto, HttpServletRequest request){
        rfConnectionService.deleteRFConnection(rfConnectionDto);
        return new ResponseData(true);
    }

    @RequestMapping("/addRFConnection")
    @ResponseBody
    public ResponseData addRFConnection(@RequestBody RFConnectionDto rfConnectionDto, HttpServletRequest request){
        rfConnectionService.addRFConnection(rfConnectionDto);
        return new ResponseData(true);
    }
}
