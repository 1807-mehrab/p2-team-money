package com.revature.stockinvestment.controller;

import com.revature.stockinvestment.service.MemberServiceLayer;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberServiceLayer memberServiceLayer;
    
    @Inject
    public MemberController(MemberServiceLayer memberServiceLayer) {
        this.memberServiceLayer = memberServiceLayer;
    }
    
}
