package SpringBoot.FirstProject.member;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void addNewMember(Member member) {
        Optional<Member> memberOptional = memberRepository
                .findMemberByEmail(member.getEmail());
        if (memberOptional.isPresent()){
            throw new IllegalStateException("Email is taken.");
        }
        memberRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        boolean exist = memberRepository.existsById(memberId);
        if(!exist) {
            throw new IllegalStateException("Member with id " + memberId + " does not exist.");
        }
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public void updateMember(Long memberId, String email, String firstname, String lastname) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException(
                "Member with id " + memberId + " does not exist."));

        if(email != null && email.length() > 0 && !Objects.equals(member.getEmail(), email)) {
            Optional<Member> memberOptional = memberRepository.findMemberByEmail(email);
            if(memberOptional.isPresent()){
                throw new IllegalStateException("Email is already taken.");
            }
            member.setEmail(email);
        }

        if (firstname != null && firstname.length() > 0 && !Objects.equals(member.getFirstname(), firstname)) {
            member.setFirstname(firstname);
        }

        if (lastname != null && lastname.length() > 0 && !Objects.equals(member.getLastname(), lastname)) {
            member.setLastname(lastname);
        }
    }
}
