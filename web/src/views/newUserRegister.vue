<template>
<div>
<user-header class="user-header"></user-header>
<v-card class="register-card">
  <form>
    <v-text-field
      v-model="nickName"
      :error-messages="nameErrors"
      :counter="10"
      label="ニックネーム"
      required
      @input="$v.name.$touch()"
      @blur="$v.name.$touch()"
      class="register-input-form"
    ></v-text-field>
    <div class="register-input-form">
      <label class="file-label">アイコン（画像ファイルを指定してください）</label>
      <div class="custom-file" style="overflow: hidden;">
        <input type="file" id="cutomfile" class="custom-file-input" name="imageFile" />
      </div>
    </div>
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      label="メールアドレス"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="register-input-form"
    ></v-text-field>
      <v-text-field
      type="password"
      v-model="password"
      :error-messages="emailErrors"
      label="パスワード"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="register-input-form"
    ></v-text-field>
      <v-text-field
      type="password"
      v-model="confirmPassword"
      :error-messages="emailErrors"
      label="確認用パスワード"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="register-input-form"
    ></v-text-field>

    <div class="v-application">
      <v-btn color="success" @click="submit" class="register-button">登録</v-btn>
    </div>
  </form>
</v-card>
</div>
</template>

<script>
import UserHeader from './userHeader'
export default {
  components: {
    UserHeader
  },
  template: '<user-header>'
}
</script>

<style scoped>
.register-card{
    width: 900px;
    margin: auto;
    margin-bottom: 60px;
    margin-top: 60px;
    padding: 20px;
  }

  .register-input-form{
    width: 600px;
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
</style>
