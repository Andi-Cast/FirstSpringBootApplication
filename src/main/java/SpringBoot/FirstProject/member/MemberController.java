package SpringBoot.FirstProject.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @PostMapping
    public void registerNewMember(@RequestBody Member member) {
        memberService.addNewMember(member);
    }

    @DeleteMapping(path = "{memberId}")
    public void deleteMember(@PathVariable("memberId")Long memberId) {
        memberService.deleteMember(memberId);
    }

    @PutMapping(path = "{memberId}")
    public void updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname) {
        memberService.updateMember(memberId, email, firstname, lastname);
    }
}
