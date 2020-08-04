<template>
<div>
<user-header class="user-header"></user-header>
<v-card class="register-card">
  <form>
    <v-text-field
      v-model="nickName"
      :error-messages="nickNameErrors"
      label="ニックネーム"
      required
      @input="$v.nickName.$touch()"
      @blur="$v.nickName.$touch()"
      class="register-input-form"
      :class="{ error : $v.nickName.$error,'form-control': true }"
    ></v-text-field>
    <v-file-input
      :rules="rules"
      accept="image/png, image/jpeg, image/bmp"
      placeholder="アイコン(画像を選択してください)"
      prepend-icon="mdi-camera"
      label="アイコン"
      name="iconImage"
      class="register-input-form"
    ></v-file-input>
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      label="メールアドレス"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="register-input-form"
      :class="{ error : $v.email.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="password"
      :error-messages="passwordErrors"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
      :passwordRules="[rules.required, rules.min]"
      :type="show ? 'text' : 'password'"
      label="パスワード"
      required
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
      counter
      @click:append="show = !show"
      class="register-input-form"
      :class="{ error : $v.password.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="confirmPassword"
      :error-messages="confirmPasswordErrors"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
      :passwordRules="[rules.required, rules.min]"
      :type="show ? 'text' : 'password'"
      label="パスワード確認"
      required
      @input="$v.confirmPassword.$touch()"
      @blur="$v.confirmPassword.$touch()"
      counter
      @click:append="show = !show"
      class="register-input-form"
      :class="{ error : $v.confirmPassword.$error,'form-control': true }"
    ></v-text-field>

    <div class="v-application">
      <v-btn @submit.prevent="submit" color="success" type="submit" class="register-button" :disabled="submitStatus === 'PENDING'">登録</v-btn>
      {{ submitStatus }}
      <p class="typo__p" v-if="submitStatus === 'OK'">Thanks for your submission!</p>
      <p class="typo__p" v-if="submitStatus === 'ERROR'">Please fill the form correctly.</p>
      <p class="typo__p" v-if="submitStatus === 'PENDING'">Sending...</p>
    </div>
  </form>
</v-card>
</div>
</template>

<script>
import UserHeader from './userHeader'
import { validationMixin } from 'vuelidate'
import { required, email, maxLength, minLength, sameAs } from 'vuelidate/lib/validators'

export default {
  mixins: [validationMixin],

  validations: {
    nickName: { required },
    email: { required, email },
    password: { required, maxLength: maxLength(40), minLength: minLength(8) },
    confirmPassword: { required, sameAsPassword: sameAs('password'), maxLength: maxLength(40), minLength: minLength(8) }
  },
  data () {
    return {
      nickName: '',
      iconImage: '',
      email: '',
      rules: [
        value => !value || value.size < 2000000 || '写真のサイズは2MB以下でお願いします'
      ],
      show: false,
      password: '',
      confirmPassword: '',
      passwordRules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 8 || 'Min 8 characters'
      },
      submitStatus: null
    }
  },
  computed: {
    nickNameErrors () {
      const errors = []
      if (!this.$v.nickName.$dirty) return errors
      !this.$v.nickName.required && errors.push('ニックネームは必ず入力して下さい')
      return errors
    },
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('メールアドレスの形式が不正です')
      !this.$v.email.required && errors.push('メールアドレスは必ず入力して下さい')
      return errors
    },
    passwordErrors () {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('パスワードは必ず入力して下さい')
      !this.$v.password.maxLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.password.minLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      return errors
    },
    confirmPasswordErrors () {
      const errors = []
      if (!this.$v.confirmPassword.$dirty) return errors
      !this.$v.confirmPassword.required && errors.push('確認用パスワードは必ず入力して下さい')
      !this.$v.confirmPassword.maxLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.confirmPassword.minLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.confirmPassword.sameAsPassword && errors.push('パスワードは同一にして下さい')
      return errors
    }
  },
  methods: {
    submit () {
      this.$v.$touch()
      if (this.$v.$invalid) {
        console.log(this.$v.$invalid)
        this.submitStatus = 'ERROR'
      } else {
        //  成功した時のロジック
        this.submitStatus = 'PENDING'
        setTimeout(() => {
          this.submitStatus = 'OK'
        }, 500)
      }
    }
  },
  components: {
    UserHeader
  },
  template: '<user-header>'
}
</script>

<style scoped>
.register-card{
    width: 700px;
    margin: auto;
    margin-bottom: 60px;
    margin-top: 60px;
    padding: 20px;
  }

  .register-input-form{
    width: 400px;
    margin: auto;
    margin-top: 50px;
  }

  .register-button{
    margin-top: 50px;
    margin-bottom: 30px;
    margin-left: 130px;
    width: 200px;
  }

  .file-label{
    color: rgba(0, 0, 0, 0.6);
  }

  .error {
    color: red;
  }
</style>
