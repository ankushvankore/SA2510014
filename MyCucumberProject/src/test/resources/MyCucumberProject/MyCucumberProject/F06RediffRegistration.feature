Feature: Registration on Rediff

  Scenario: To validate registration process on Rediff
    Given Launch "https://register.rediff.com/register/register.php?FormName=user_details"
    When Enter following data
      | Madan S | madhan_s | madhan@123 | 19 | 12 | 2000 | Male |
    Then Registration done
